# Plataforma d'Informació sobre Animals 

## Esquema de la Base de Dades

A continuació, es presenta l’estructura de la base de dades per a la plataforma d’informació sobre animals. Aquesta base de dades es basa en el model NoSQL i es compon d’una col·lecció principal: `animals`.

---

### **Col·lecció principal: Animals**
Aquesta col·lecció conté informació detallada sobre cada animal. Inclou un camp de data per permetre ordenar-los segons la seva creació.

#### Exemple de document:
```json
{
  "_id": "animal_001",
  "nom_comu": "Dofí mular",
  "nom_cientific": "Tursiops truncatus",
  "descripcio": "Mamífer marí intel·ligent que viu en oceans temperats i tropicals.",
  "habitat": "ocean",
  "dieta": "carnívor",
  "comportament": "Social i juganer",
  "imatges": [
    {
      "url": "https://example.com/dofi1.jpg",
      "descripcio": "Dofí saltant fora de l'aigua"
    }
  ],
  "caracteristiques": {
    "longitud": "2-4 metres",
    "pes": "150-300 kg",
    "esperanca_vida": "40-50 anys"
  },
  "data_creacio": "2025-01-01"
}
```

#### Camps destacats:
- **nom_comu** i **nom_cientific**: Per permetre cerques per nom comú o científic.
- **habitat**: Defineix el tipus d'hàbitat de l’animal (ex: "aigua dolça", "mar" o "ocean").
- **dieta**: Tipus de dieta (ex: "carnívor", "herbívor", "omnivor").
- **imatges**: Llista d’objectes que contenen URL d’imatges i descripcions.
- **comentaris**: Llista de comentaris associats a l’animal.
- **data_creacio**: Data de creació del document per permetre ordenar els animals.

#### Justificació:
Aquesta col·lecció és la principal perquè conté tota la informació necessària sobre els animals. El camp `data_creacio` garanteix que es pugui ordenar i gestionar cronològicament la informació.

---

## Justificació de l’Estructura

1. **Flexibilitat:** El model NoSQL permet adaptar la informació segons les necessitats de cada animal sense un esquema rígid.
2. **Eficiència en consultes:** Es poden realitzar cerques i filtres ràpidament gràcies als camps claus com `nom_comu`, `nom_cientific` o `habitat`.
3. **Ordenació per data:** El camp `data_creacio` a la col·lecció `animals` garanteix una ordenació cronològica dels documents.
4. **Escalabilitat:** Aquesta estructura pot gestionar grans volums de dades i créixer fàcilment amb més informació, comentaris i imatges.
