package pl.wnukedwarda.board;

public class Field {

    private int x;
    private int y;
    private State state;

    public Field(int x, int y, State state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public char stateToChar() {
        char token;

        switch (state) {
            case EMPTY:
                token = ' ';
                break;

            case HIT:
                token = 'o';
                break;

            default:
                token = '?';
        }
        return token;
    }

    public void setState(State state){
        this.state = state;
    }
}
