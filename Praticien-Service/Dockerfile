# Utilisation de l'image OpenJDK 17
FROM openjdk:17-jdk-slim

# Définition du répertoire de travail
WORKDIR /app

# Copier le fichier JAR généré
COPY target/ServicePraticien-0.0.1-SNAPSHOT.jar app.jar

# Exposition du port
EXPOSE 8082

# Commande de lancement
CMD ["java", "-jar", "app.jar"]
