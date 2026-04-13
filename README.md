<div align="center">

![Java](https://img.shields.io/badge/Java%2017+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Java%20Swing-5382A1?style=for-the-badge&logo=java&logoColor=white)
![Game](https://img.shields.io/badge/Game-Desktop-red?style=for-the-badge&logo=nintendo&logoColor=white)

<br>

<img width="576" height="637" alt="7" src="https://github.com/user-attachments/assets/ed5aa009-ad65-4109-ba2e-00f26e6c1927" />

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
| <img width="175" height="175" alt="monty" src="https://github.com/user-attachments/assets/baf783cc-e8c3-424f-abe3-98750a308036" /> | **Atrapar a Monty** | `+1` |
| <img width="175" height="175" alt="piranha" src="https://github.com/user-attachments/assets/5b1a47bc-817e-4ab2-b287-7d4915821726" /> | **Tocar la Planta** | `-1` |

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
```

## Guía de Inicio
Clonar: git clone https://github.com/sebastian12343254/MarioGame

Compilar en tu editor favorito
