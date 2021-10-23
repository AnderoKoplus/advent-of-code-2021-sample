# build phase
FROM maven:3.6.0-jdk-11-slim AS build
COPY . /app
RUN mvn -B -f /app/pom.xml clean package

# run phase
FROM openjdk:11-jre-slim

# copy artifacts from build phase
COPY --from=build /app/day01/target/day01-1.0-SNAPSHOT-shaded.jar /app/day01.jar

# copy inputs
COPY data /app/data

# setup input selection - this can be randomized in later stages
ENV INPUT_DAY01=./data/day01/input.txt

# copy solution runner
COPY run.sh /app
RUN chmod +x /app/run.sh

WORKDIR /app

ENTRYPOINT ["./run.sh"]

