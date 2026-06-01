# 🏥 Système de Gestion de Pharmacie

## 📋 Description

Application complète de gestion de pharmacie permettant :
- ✅ Gestion des médicaments
- ✅ Gestion des dispensaires
- ✅ Gestion des commandes
- ✅ Suivi du stock
- ✅ Alertes de réapprovisionnement
- ✅ API REST complète
- ✅ Documentation interactive (Swagger)

## 🛠️ Technologies

- **Backend** : Spring Boot 3.5.3
- **Database** : H2 (développement) / PostgreSQL (production)
- **ORM** : JPA / Hibernate
- **Documentation API** : Swagger/OpenAPI
- **Build** : Maven
- **Java** : 21 LTS

## 🚀 Démarrage Rapide

### Prérequis
- Java 21+
- Maven 3.6+
- Git

### Installation

```bash
# Cloner le projet
git clone https://github.com/Youssefdev-clod/PFE.git
cd PFE

# Compiler le projet
mvn clean install

# Lancer l'application
mvn spring-boot:run
```

### Accès à l'Application

- 🌐 API : http://localhost:8080/api
- 📖 Documentation Swagger : http://localhost:8080/api/swagger-ui.html
- 💾 Console H2 : http://localhost:8080/api/h2-console

## 📚 Endpoints API

### Médicaments
- `GET /api/medicaments` - Récupérer tous les médicaments
- `POST /api/medicaments` - Créer un médicament
- `GET /api/medicaments/{id}` - Récupérer un médicament
- `PUT /api/medicaments/{id}` - Mettre à jour un médicament
- `DELETE /api/medicaments/{id}` - Supprimer un médicament
- `GET /api/medicaments/reappro/alerte` - Médicaments à réapprovisionner
- `GET /api/medicaments/categorie/{categorie}` - Médicaments par catégorie

### Dispensaires
- `GET /api/dispensaires` - Récupérer tous les dispensaires
- `POST /api/dispensaires` - Créer un dispensaire
- `GET /api/dispensaires/{id}` - Récupérer un dispensaire
- `PUT /api/dispensaires/{id}` - Mettre à jour
- `DELETE /api/dispensaires/{id}` - Supprimer

### Commandes
- `GET /api/commandes` - Récupérer toutes les commandes
- `POST /api/commandes` - Créer une commande
- `GET /api/commandes/{id}` - Récupérer une commande
- `GET /api/commandes/dispensaire/{id}` - Commandes par dispensaire
- `PATCH /api/commandes/{id}/statut` - Mettre à jour le statut

## 📁 Structure du Projet

```
PFE/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/pharmacie/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── PharmacieApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 👨‍💻 Auteur

Youssefdev-clod

## 📝 License

MIT
