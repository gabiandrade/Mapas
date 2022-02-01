package maps;

public interface OperationsObserver {

    void notifyDataSet(Operations operations, Object output, StringBuilder map);
}
