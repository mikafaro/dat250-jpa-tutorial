# DAT250: Software Technology Experiment Assignment 4 Report

## Introduction

The aim of this experiment is to learn about and understand the Java Persistence Architecture
and Object Relational Mapping.

## Experiment 1: Setup and Tutorial

I immediately ran into trouble from the start trying to build with gradle.
The build failed with an exception:

```Could not create service of type ScriptPluginFactory using BuildScopeServices.createScriptPluginFactory().```

Undoubtedly this is due to Ubuntu having an ancient gradle version in the repos, and so should be a quick fix
with a ppa, but for now it seems to work if I just build the project in Intellij. Will fix this is necessary later.
In the end I could run the skeleton program seemingly without failure.

## Experiment 2