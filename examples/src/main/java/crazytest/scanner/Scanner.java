package crazytest.scanner;

public interface Scanner {
    public String scan();

    public boolean hasNext();
    
    public void allowPassage();
    public void denyPassage();
}
