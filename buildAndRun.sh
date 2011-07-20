mvn dependency:purge-local-repository clean install dependency:copy-dependencies
java -cp target/CdiTry-1.0-SNAPSHOT.jar:target/dependency/weld-se-1.1.1.Final.jar org.jboss.qa.test.cditry.AppWeld
