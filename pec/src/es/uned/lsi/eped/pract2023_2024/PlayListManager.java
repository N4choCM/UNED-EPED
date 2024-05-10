package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayListManager implements PlayListManagerIF{
  // MARK I - Attributes
  private List<PlayList> playLists;

  // MARK II - Constructors
  /*
   * Inicializará el componente 
   * sin ninguna lista de reproducción.
   */
  public PlayListManager(){}

  // MARK III - Methods
  // READ
  /*
   * Comprueba si existe una lista de reproducción 
   * a partir de su identificador.
   * @param playListID - el identificador de la lista de reproducción
   */
  @Override
  public boolean contains(String playListID) {
    for(int i = 0; i < this.playLists.size(); i++){
      PlayList playList = this.playLists.get(i);
      if(playList.getPlayListID().equals(playListID)){
        return true;
      }
    }
    return false;
  }

  /*
   * Devuelve una lista de reproducción existente
   * a partir de su identificador.
   * @param playListID - el identificador de la lista de reproducción
   */
  @Override
  public PlayList getPlayList(String playListID) {
    if(this.contains(playListID)){
      for(int i = 0; i < this.playLists.size(); i++){
        PlayList playList = this.playLists.get(i);
        if(playList.getPlayListID().equals(playListID)){
          return playList;
        }
      }
    }
    return null;
  }

  /*
   * Devuelve la lista de los identificadores 
   * de todas las listas de reproducción existentes.
   */
  @Override
  public ListIF<String> getIDs() {
    ListIF<String> playListIDs = new List<String>();
    for(int i = 0; i < this.playLists.size(); i++){
      PlayList playList = this.playLists.get(i);
      playListIDs.insert(playListIDs.size() + 1, playList.getPlayListID());
    }
    return playListIDs;
  }

  // UPDATE
  /*
   * Permite crear una nueva lista de reproducción
   * a partir de un identificador que no pertenece 
   * a otra lista de reproducción existente.
   */
  @Override
  public void createPlayList(String playListID) {
    if(!this.contains(playListID)){
      PlayList playList = new PlayList(playListID, new List<Integer>());
      this.playLists.insert(this.playLists.size() + 1, playList);
    }
  }

  /*
   * Permite eliminar una lista de reproducción existente
   * a partir de su identificador.
   */
  @Override
  public void removePlayList(String playListID) {
    if(this.contains(playListID)){
      for(int i = 0; i < this.playLists.size(); i++){
        PlayList playList = this.playLists.get(i);
        if(playList.getPlayListID().equals(playListID)){
          this.playLists.remove(i);
        }
      }
    }
  }
}
