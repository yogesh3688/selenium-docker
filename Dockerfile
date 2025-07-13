FROM bellsoft/liberica-openjdk-alpine:21-cds

# Install curl jq
RUN apk add curl jq


# Workspace
WORKDIR /home/selenium-docker

# add the required files
ADD target/docker-resources     ./
ADD runner.sh                 runner.sh

# execute the runner bash file
ENTRYPOINT sh runner.sh


