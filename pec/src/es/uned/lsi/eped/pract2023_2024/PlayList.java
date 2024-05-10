package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayList implements PlayListIF {
  // MARK I - Attributes
  private String playListID;
  private ListIF<Integer> playListIds;

  // MARK II - Constructors
  /*
   * Crea una nueva lista de reproducción.
   * @param PlayListId - el identificador de la lista de reproducción
   * @param playListIds - la secuencia de identificadores de las canciones
   */
  public PlayList(String PlayListId, ListIF<Integer> playListIds){
    this.playListID = PlayListId;
    this.playListIds = playListIds;
  }

  // MARK III - Getters and Setters
  public String getPlayListID() {
    return this.playListID;
  }

  public void setPlayListID(String playListID) {
    this.playListID = playListID;
  }

  // MARK III - Methods
  // READ
  /*
   * Devuelve la secuencia de los identificadores de canciones
   * almacenada en la lista de reproducción, en el mismo orden 
   * en el que se encuentran almacenados en la lista.
   */
  @Override
  public ListIF<Integer> getPlayList() {
    return this.playListIds;
  }

  // UPDATE
  /*
   * Dada una lista de identificadores de canciones, 
   * añada dichos identificadores a la lista de reproducción.
   * @param listOfTunes - la secuencia de identificadores de las canciones
   */
  @Override
  public void addListOfTunes(ListIF<Integer> listOfTunes) {
    for(int i = 0; i < listOfTunes.size(); i++){
      this.playListIds.insert(listOfTunes.get(i), this.playListIds.size() + 1);
    }
  }

  /*
   * Dado un identificador de canción, elimina toda aparición de dicho
   * identificador en la lista de reproducción.
   * @param tuneID - el identificador de la canción que se desea eliminar
   */
  @Override
  public void removeTune(int tuneID) {
    for(int i = 0; i < this.playListIds.size(); i++){
      if(this.playListIds.get(i) == tuneID){
        this.playListIds.remove(i);
      }
    }
  }
}
