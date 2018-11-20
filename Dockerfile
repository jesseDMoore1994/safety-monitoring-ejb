FROM airhacks/glassfish:v5
ADD scripts/populate_servers ${GLASSFISH_HOME}/bin
ADD scripts/safety_monitoring_client ${GLASSFISH_HOME}/bin
ADD build/libs ${DEPLOYMENT_DIR}
