FROM airhacks/glassfish:v5
ADD scripts/safety_monitoring_client ${GLASSFISH_HOME}/bin
ADD build/libs ${DEPLOYMENT_DIR}
