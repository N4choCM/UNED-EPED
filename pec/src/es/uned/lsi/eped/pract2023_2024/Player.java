package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class Player implements PlayerIF {

  // MARK I - Attributes
  private TuneCollectionIF repository;
  private PlayListManager playListManager;
  private PlayBackQueue queue;
  private RecentlyPlayed recentlyPlayedTunes;

  // MARK II - Constructors
  /** Constructor de la clase que implementa PlayerIF 
   *@param -una colección de canciones como un objeto TuneCollectionIF 
   *-un entero representando el número máximo de canciones 
   *reproducidas que se pueden almacenar 
   */
  Player(TuneCollectionIF repository, int maxRecentlyPlayed){
    this.repository = repository;
    this.playListManager = new PlayListManager();
    this.queue = new PlayBackQueue();
    this.recentlyPlayedTunes = new RecentlyPlayed(maxRecentlyPlayed);
  }

  // MARK III - Methods
  // READ
  /**
   * Devuelve la secuencia de los identificadores de todas las listas de
   * reproducción existentes en el reproductor.
   */
  @Override
  public ListIF<String> getPlayListIDs() {
    return this.playListManager.getIDs();
  }

  /**
   * Devuelve una secuencia con el contenido de una lista de reproducción
   * concreta del reproductor a partir de su identificador.
   */
  @Override
  public ListIF<Integer> getPlayListContent(String playListID) {
    return this.playListManager.getPlayList(playListID).getPlayList();
  }

  /**
   * Devuelve una secuencia con el contenido de la cola de reproducción.
   */
  @Override
  public ListIF<Integer> getPlayBackQueue() {
    return this.queue.getContent();
  }

  /**
   * Devuelve una secuencia con las últimas canciones reproducidas.
   */
  @Override
  public ListIF<Integer> getRecentlyPlayed() {
    return this.recentlyPlayedTunes.getContent();
  }

  // UPDATE
  /*
   * Permite crear una nueva lista de reproducción a partir de un
   * identificador para la misma. Si ya existe una lista de reproducción con dicho
   * identificador, no hace nada, para así poder garantizar la unicidad 
   * del identificador de cada lista de reproducción.
   */
  @Override
  public void createPlayList(String playListID) {
    if(!this.playListManager.contains(playListID)){
      this.playListManager.createPlayList(playListID);
    }
    throw new RuntimeException("PlayList already exists");
  }

  /*
   * Permite eliminar una de las listas de reproducción existentes a partir
   * de su identificador. Si no existe ninguna lista de reproducción 
   * con dicho identificador, no hace nada.
   * @param playListID - el identificador de la lista de reproducción
   */
  @Override
  public void removePlayList(String playListID) {
    if(this.playListManager.contains(playListID)){
      this.playListManager.removePlayList(playListID);
    }
    throw new RuntimeException("PlayList does not exist");
  }

  /*
   * Permite añadir una lista de canciones del repositorio, a partir de sus
   * identificadores, a una lista de reproducción existente en el reproductor seleccionada
   * mediante su identificador. Si no existe ninguna lista de reproducción con dicho
   * identificador, no se hace nada.
   * @param playListID - el identificador de la lista de reproducción
   * @param lT - la lista de identificadores de las canciones a añadir
   */
  @Override
  public void addListOfTunesToPlayList(String playListID, ListIF<Integer> listOfTunes) {
    if(this.playListManager.contains(playListID)){ 
      this.playListManager.getPlayList(playListID).addListOfTunes(listOfTunes);
    }
  }

  /*
   * Permite añadir todas las canciones del repositorio que cumplan unos
   * criterios a una lista de reproducción existente en el reproductor 
   * seleccionada mediante su identificador. Si no existe ninguna 
   * lista de reproducción con dicho identificador, no se hace nada.
   * @param playListID - el identificador de la lista de reproducción
   * @param title - el título de las canciones a añadir
   * @param author - el autor de las canciones a añadir
   * @param genre - el género de las canciones a añadir
   * @param album - el álbum de las canciones a añadir
   * @param min_year - el año mínimo de las canciones a añadir
   * @param max_year - el año máximo de las canciones a añadir
   * @param min_duration - la duración mínima de las canciones a añadir
   * @param max_duration - la duración máxima de las canciones a añadir
   */
  @Override
  public void addSearchToPlayList(
    String playListID, 
    String title, 
    String author, 
    String genre, 
    String album, 
    int min_year, 
    int max_year,
    int min_duration, 
    int max_duration
    ) {
    if(this.playListManager.contains(playListID)){
      int currentLastId = this.playListManager.getPlayList(playListID).getPlayList().size() - 1;
      List<Integer> searchedTunes = new List<Integer>();
      Query query = new Query(
        title, 
        author, 
        genre, 
        album, 
        min_year, 
        max_year, 
        min_duration, 
        max_duration
        );
      for(int i = 0; i < this.repository.size(); i++){
        TuneIF tune = this.repository.getTune(i);
        if(tune.match(query)){
          searchedTunes.insert(searchedTunes.size() + 1, currentLastId + 1);
          currentLastId++;
        }
      }
      this.playListManager.getPlayList(playListID).addListOfTunes(searchedTunes);
    }
    throw new RuntimeException("PlayList does not exist");
  }

  /*
   * Permite eliminar una canción, a partir de su identificador, de una lista
   * de reproducción existente en el reproductor seleccionada mediante su identificador. Si no
   * existe ninguna lista de reproducción con dicho identificador, no se hace nada.
   * @param playListID - el identificador de la lista de reproducción
   * @param tuneID - el identificador de la canción a eliminar
   */
  @Override
  public void removeTuneFromPlayList(String playListID, int tuneID) {
    if(this.playListManager.contains(playListID)){
      this.playListManager.getPlayList(playListID).getPlayList().remove(tuneID);
    }
  }

  /*
   * Permite añadir una lista de canciones del repositorio, 
   * a partir de sus identificadores, a la cola de reproducción.
   * @param listOfTunes - la lista de identificadores de las canciones a añadir
   */
  @Override
  public void addListOfTunesToPlayBackQueue(ListIF<Integer> listOfTunes) {
    for(int i = 0; i < listOfTunes.size(); i++){
      this.queue.addTunes(listOfTunes);
    }
  }

  /*
   * Permite añadir todas las canciones del repositorio que cumplen 
   * unos criterios a la cola de reproducción.
   * @param title - el título de las canciones a añadir
   * @param author - el autor de las canciones a añadir
   * @param genre - el género de las canciones a añadir
   * @param album - el álbum de las canciones a añadir
   * @param min_year - el año mínimo de las canciones a añadir
   * @param max_year - el año máximo de las canciones a añadir
   * @param min_duration - la duración mínima de las canciones a añadir
   * @param max_duration - la duración máxima de las canciones a añadir
   */
  @Override
  public void addSearchToPlayBackQueue(
    String title,
    String author, 
    String genre, 
    String album, 
    int min_year, 
    int max_year, 
    int min_duration,
    int max_duration
    ) {
    int currentLastId = this.queue.getContent().size() - 1;
    List<Integer> searchedTunes = new List<Integer>();
    Query query = new Query(
      title, 
      author, 
      genre, 
      album, 
      min_year, 
      max_year, 
      min_duration, 
      max_duration
      );
    for(int i = 0; i < this.repository.size(); i++){
      TuneIF tune = this.repository.getTune(i);
      if(tune.match(query)){
        searchedTunes.insert(searchedTunes.size() + 1, currentLastId + 1);
        currentLastId++;
      }
    }
    this.queue.addTunes(searchedTunes);
  }

  /*
   * Permite añadir una de las listas de reproducción existentes en el repositorio, 
   * seleccionada a partir de su identificador, a la cola de reproducción. 
   * Si no existe ninguna lista de reproducción con dicho identificador, no se hace nada.
   * @param playListID - el identificador de la lista de reproducción
   */
  @Override
  public void addPlayListToPlayBackQueue(String playListID) {
    if(this.playListManager.contains(playListID)){ 
      ListIF<Integer> playListContent = this.playListManager.getPlayList(playListID).getPlayList();
      this.queue.addTunes(playListContent);
    }
    throw new RuntimeException("PlayList does not exist");
  }

  /*
   * Permite vaciar la cola de reproducción.
   */
  @Override
  public void clearPlayBackQueue() {
    if(!this.queue.isEmpty()){
      this.queue.clear();
    }
    throw new RuntimeException("PlayBackQueue is already empty");
  }

  /*
   * Reproduce la siguiente canción disponible en la cola de reproducción. 
   * Guarda la canción reproducida en el almacén de últimas canciones reproducidas.
   */
  @Override
  public void play() {
    if(!this.queue.isEmpty()){
      int tuneID = this.queue.getFirstTune();
      this.queue.extractFirstTune();
      this.recentlyPlayedTunes.addTune(tuneID);
    }
  }
}
