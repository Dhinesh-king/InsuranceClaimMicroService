FROM openjdk:8
EXPOSE 8083
ADD target/InsuranceClaimService.jar InsuranceClaimService.jar
ENTRYPOINT ["java","-jar","/InsuranceClaimService.jar"]