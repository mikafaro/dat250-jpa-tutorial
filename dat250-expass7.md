# DAT250 Experiment Assignment 7 Report

## Task 1 - Using a Dockerized application: PostgreSQL

For this experiment I take a previous assignment application using a H2 database and change it
so that it uses postgres in a docker container.

I first pulled the latest postgres container from Dockerhub, and then I had to figure out
what port to export as well as the environment variables to set. From the image documentation it
became apparent that the required variable is POSTGRES_PASSWORD. I had to resort to an internet search
to find the port used as this was not mentioned in the documentation for the docker image. The below
command is what I ended up with.

```
docker run -p 5432:5432 \
  -e POSTGRES_PASSWORD="secret" \
  -d --name my-postgres --rm postgres
```

After running the postgres container I created a user for the jpa_client

```SQL
CREATE USER jpa_client WITH PASSWORD 'secret';
```

and checked that the creation of this user was successful, which it was.

```sql
SELECT * FROM pg_catalog.pg_user;
```

Now I added the postgres dependency to build.gradle.kts,
and I changed the connection parameters in persistence.xml
to the new postgres database along with the new username and password.

Running the tests at this point failed, as the database tables
were not yet set up. Though with some changes to the persistence.xml file
I could get the required SQL queries to set them up in the file
schema.up.sql, which I then could drag to the database to perform the setup.

After this the tests still failed as the user jpa_client did not have
the required permissions to access the tables. This was solved
by granting the user access with the following query

```sql
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO jpa_client;
```

Now I could run the tests successfully and the first experiment was complete.

## Task 2 - Building you own dockerized application

