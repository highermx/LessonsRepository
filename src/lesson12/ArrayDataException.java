package lesson12;

public class ArrayDataException extends Exception {

  private final int row;
  private final int column;

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public ArrayDataException(String message, int row, int column) {
    super(message);
    this.row = row;
    this.column = column;
  }

  public String getErrorPosition() {

    return String.format("Ошибка в ячейке: ", row, column);
  }
}


