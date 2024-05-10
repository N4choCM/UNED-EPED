package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Queue;

public class PlayBackQueue implements PlayBackQueueIF {
  // MARK I - Attributes
  private Queue<Integer> tunesIds;

  // MARK II - Constructors
  public PlayBackQueue(){}

  // MARK III - Methods
  // READ
  /*
   * Devuelve la secuencia con los identificadores de las canciones 
   * que están programadas para su reproducción en el mismo orden 
   * en el que estas fueron introducidas.
   */
  @Override
  public ListIF<Integer> getContent() {
    List<Integer> tunesIdsList = new List<Integer>();
    for(int i = 0; i < this.tunesIds.size(); i++){
      tunesIdsList.insert(this.tunesIds.getFirst(), i + 1);
      this.tunesIds.dequeue();
    }
    return tunesIdsList;
  }

  /*
   * Indica si la cola de reproducción está vacía o no.
   */
  @Override
  public boolean isEmpty() {
    return this.tunesIds.isEmpty();
  }

  /*
   * Devuelve el identificador de la primera canción 
   * presente en una cola de reproducción no vacía.
   */
  @Override
  public int getFirstTune() {
    if(!this.isEmpty()){
      return this.tunesIds.getFirst();
    }
    throw new RuntimeException("PlayBackQueue is empty");
  }

  // UPDATE
  /*
   * Extrae el identificador de la primera canción
   *  presente en una cola de reproducción no vacía.
   */
  @Override
  public void extractFirstTune() {
    if(!this.isEmpty()){
      this.tunesIds.dequeue();
    }
    throw new RuntimeException("PlayBackQueue is empty");
  }

  /*
   * Dada una lista de identificadores de canciones, 
   * añada dichos identificadores a la cola de reproducción.
   * @param listOfTunes - la secuencia de identificadores de las canciones
   */
  @Override
  public void addTunes(ListIF<Integer> listOfTunes) {
    for(int i = 0; i < listOfTunes.size(); i++){
      this.tunesIds.enqueue(listOfTunes.get(i));
    }
  }

  /*
   * Vacía por completo la cola de reproducción.
   */
  @Override
  public void clear() {
    this.tunesIds.clear();
  }
}
