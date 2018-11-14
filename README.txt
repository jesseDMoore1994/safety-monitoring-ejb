This is a JAX-WS java project to simulate sensor data from doors and windows.
This application is built and supported in java 1.8.0 since subsequent versions of java remove JAX-WS

Problem description
--------------------------------------------------------------------------------------------------------
Two servers:
   doors:
       [
           Entry Door,
           VIP door
       ]
   windows:
       [
           VIPWindowNorth,
           VIPWindowEast
       ]

door states:
    open
    closed and not locked
    closed and locked
window states:
    open
    half open
    closed and not locked
    closed and locked

Interfaces that are available to the client:
window server
    input:
        window number
    output:
        if window number exists, return status.
Door server
    input:
        door name
    output:
        if door name exists, return status.


Installation and usage instructions
---------------------------------------------------------------------------------------------------------

This application has been proven to run on the machines in the linux lab in the UAH CS department. There is a small hiccup with the machines in that the default ENV sets the java version to 10,
    which does not easily support JAX-WS as the Java EE features have already been removed. Luckily, there are older versions installed that do support JAX-WS out on /netshare.

if you are running this application on a machine in the linux lab, be sure to run `source configure_env` to adjust the ENV to use java 1.8. When you want to restore your old ENV settings,
    run `source unconfigure_env` to restore what you had previously.

To build (Linux):
    open a command prompt and navigate to this directory.
    run './gradlew build'

To build (Windows):
    open a command prompt and navigate to this directory.
    run 'gradlew.bat build'

To test (Linux):
    open a command prompt and navigate to this directory.
    run './gradlew test'

To test (Windows):
    open a command prompt and navigate to this directory.
    run 'gradlew.bat test'

To launch the server (Linux):
    open a command prompt and navigate to this directory.
    build the project. (If not already built.)
    'java -cp build/libs/safety-monitoring-1.0.0.jar safety_monitoring.ServerLauncher'

To launch the server (Windows):
    open a command prompt and navigate to this directory.
    build the project. (If not already built.)
    'java -cp build/libs/safety-monitoring-1.0.0.jar safety_monitoring.ServerLauncher'

To populate the sensors for Very Important Company (Linux):
    open a command prompt and navitgate to this directory.
    build the project. (If not already built.)
    'java -cp build/libs/safety-monitoring-1.0.0.jar safety_monitoring.PopulateVeryImportantCompany'

To populate the sensors for Very Important Company (Windows):
    open a command prompt and navitgate to this directory.
    build the project. (If not already built.)
    'java -cp build/libs/safety-monitoring-1.0.0.jar safety_monitoring.PopulateVeryImportantCompany'

To use the client (Linux):
    open a command prompt and navigate to this directory.
    build the project. (If not already built.)
    'java -cp build/libs/safety-monitoring-1.0.0.jar safety_monitoring.SafetyMonitoringClient [ "Window" | "Door" | "Room" ] [ "VIP Door" | "Entry Door" | "VIPWindowNorth" | "VIPWindowEast" | "VIP Room" | "Receptionist Room" ]'

To use the client (Windows):
    open a command prompt and navigate to this directory.
    build the project. (If not already built.)
    'java -cp build/libs/safety-monitoring-1.0.0.jar safety_monitoring.SafetyMonitoringClient [ "Window" | "Door" | "Room" ] [ "VIP Door" | "Entry Door" | "VIPWindowNorth" | "VIPWindowEast" | "VIP Room" | "Receptionist Room" ]'
