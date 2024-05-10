package es.uned.lsi.eped.pract2023_2024;

public class Tune implements TuneIF {

  // MARK I - Attributes
  private String title;
  private String artist;
  private String genre;
  private String album;
  private int year;
  private int duration;

  // MARK II - Constructors
  /** Constructor de la clase que implementa TuneIF 
   * @param -una cadena de caracteres con el título de la canción 
   * -una cadena de caracteres con el autor de la canción 
   * -una cadena de caracteres con el género de la canción 
   * -una cadena de caracteres con el álbum al que pertenece 
   * -un entero con el año de publicación de la canción 
   * -un entero con la duración en segundos de la canción 
   * @pre -t != "" && a != "" && g != "" && al != "" && y > 0 && d > 0 
   */
  public Tune(String title, String artist, String genre, String album, int year, int duration) {
    checkEmptyString(title, "Title");
    checkEmptyString(artist, "Artist");
    checkEmptyString(genre, "Genre");
    checkEmptyString(album, "Album");
    checkNegativeValue(year, "Year");
    checkNegativeValue(duration, "Duration");

    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.album = album;
    this.year = year;
    this.duration = duration;
  }

  // MARK III - Methods
  /*
   * Indica si la canción cumple o no con unos criterios de búsqueda dados.
   * @param -un objeto QueryIF con los criterios de búsqueda
   */
  @Override
  public boolean match(QueryIF q) {
    if(q.getAlbum().equals(this.album) 
      || q.getAuthor().equals(this.artist) 
      || q.getGenre().equals(this.genre) 
      || q.getTitle().equals(this.title) 
      || (q.getMin_year() <= this.year && this.year <= q.getMax_year()) 
      || (q.getMin_duration() <= this.duration && q.getMax_duration() >= this.duration)) {
      return true;
    }
    return false;
  }

  // Helper method to check for empty strings
  private void checkEmptyString(String value, String fieldName) {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException(fieldName + " cannot be empty");
    }
  }

  // Helper method to check for negative values
  private void checkNegativeValue(int value, String fieldName) {
    if (value < 0) {
      throw new IllegalArgumentException(fieldName + " cannot be negative");
    }
  }
}
