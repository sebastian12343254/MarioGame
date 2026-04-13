<div align="center">

![Java](https://img.shields.io/badge/Java%2017+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Java%20Swing-5382A1?style=for-the-badge&logo=java&logoColor=white)
![Game](https://img.shields.io/badge/Game-Desktop-red?style=for-the-badge&logo=nintendo&logoColor=white)

<br>

<img src="./7.png" width="50"> 

</div>

# Mario Whac-A-Mole

---

## Descripción
Un  juego de escritorio inspirado en el clásico arcade. En esta versión temática de Super Mario, el jugador debe hacer clic sobre **Monty Mole** para ganar puntos, mientras evita a la peligrosa **Planta Piraña** que resta puntuación. 

El juego utiliza `javax.swing.Timer` para gestionar las apariciones aleatorias de forma independiente, creando una experiencia dinámica y desafiante.

---

## Mecánicas del Juego

| Elemento | Acción | Puntos |
| :---: | :--- | :---: |
| <img src="./monty.png" width="50"> | **Atrapar a Monty** | `+1` |
| <img src="./piranha.png" width="50"> | **Tocar la Planta** | `-1` |

* **Velocidad Variable:** El topo aparece cada 1000ms, mientras que la planta aparece cada 1500ms.
* **Sistema de Red**: Tablero de 3x3 generado con `GridLayout`.
* **Escalado de Imágenes:** Las imágenes se renderizan suavemente a 150x150 píxeles.

---

## Aspectos Técnicos Destacados

El proyecto implementa una lógica de **prevención de superposición** para evitar que el topo y la planta ocupen el mismo lugar al mismo tiempo:

```java
setMoleTimer = new Timer(1000, e -> {
    int num = random.nextInt(9);
    JButton moleTile = buttons[num];

    if(currPlantTile == moleTile) return; 

    currMoleTile = moleTile;
    moleTile.setIcon(moleIcon);
});