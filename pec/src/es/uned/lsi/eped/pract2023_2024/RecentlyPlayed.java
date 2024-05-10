package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class RecentlyPlayed implements RecentlyPlayedIF {
  // MARK I - Attributes
  private Integer[] tunesIds;

  // MARK II - Constructors
  public RecentlyPlayed(int maxNumberOfTunes){
    this.tunesIds = new Integer[maxNumberOfTunes];
  }

  // MARK III - Methods
  // READ
  /*
   * Devuelve la secuencia de los identificadores de 
   * las últimas canciones reproducidas que se encuentran almacenadas,
   *  en el orden inverso a su orden de reproducción.
   */
  @Override
  public ListIF<Integer> getContent() {
    List<Integer> tunesIdsList = new List<Integer>();
    for(int i = this.tunesIds.length - 1; i >= 0; i--){
      if(this.tunesIds[i] != null){
        tunesIdsList.insert(this.tunesIds[i], tunesIdsList.size() + 1);
      }
    }
    return tunesIdsList;
  }

  // UPDATE
  /*
   * Añade una nueva canción reproducida a la estructura 
   * asegurándose de que nunca se almacenan más canciones reproducidas 
   * que las indicadas por el tamaño máximo indicado en el constructor.
   */
  @Override
  public void addTune(int tuneID) {
    if(this.tunesIds[this.tunesIds.length - 1] != null){
      throw new RuntimeException("RecentlyPlayed is full");
    }
    // Mover todos los elementos una posición hacia la derecha
    for (int i = this.tunesIds.length - 1; i > 0; i--) {
      this.tunesIds[i] = this.tunesIds[i - 1];
    }
    // Agregar la nueva canción al principio
    this.tunesIds[0] = tuneID;
  }
}
