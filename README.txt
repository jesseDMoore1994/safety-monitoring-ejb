This is an Enterprise Java Beans java project to simulate sensor data from doors and windows.
This application is built and supported in java 1.8.0 since subsequent versions of java remove EJB interfaces

Problem description
--------------------------------------------------------------------------------------------------------
Two servers:
   doors:
       [
           EntryDoor,
           VIPDoor
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
        window name
    output:
        if window number exists, return status.
Door server
    input:
        door name
    output:
        if door name exists, return status.


Installation and usage instructions
---------------------------------------------------------------------------------------------------------

This application has been proven to run on the glassfish VM's provided by Dr. Etzkorn in the UAH CS department.
A large amount of development work was done using Glassfish docker images.

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
    Take the jar from the output of the build process (located at ./build/libs/safety-monitoring-ejb-1.0.0.jar) and deploy it on glassfish.

To launch the server (Docker):
    If you have docker installed, you can deploy the application on the glassfish docker image bundled in source control. After building the application, run the "build_deployment" script, followed by the "run_deployment" script to launch the container with the jar set to autodeploy.

To use the client (Linux):
    open a command prompt and navigate to this directory.
    build the project. (If not already built.)
    navigate into the scripts directory, and edit the "safety_monitoring_client" script variables to your environment.
    run the script with the following syntax:
        ./safety_monitoring_client [ "Window" | "Door" ] [ "VIP Door" | "Entry Door" | "VIPWindowNorth" | "VIPWindowEast" ]

To use the client (Docker):
    build the project. (If not already built.)
    Open an interactive shell to the docker image with: docker exec -it <image_name> bash
    (to find the image name, do `docker ps`)
    The script defaults are set up to run in the docker environment
    run the script with the following syntax:
        ./safety_monitoring_client [ "Window" | "Door" ] [ "VIP Door" | "Entry Door" | "VIPWindowNorth" | "VIPWindowEast" ]
