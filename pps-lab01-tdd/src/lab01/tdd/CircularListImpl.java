package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private enum Direction {NEXT, PREVIOUS;}

    private List<Integer> circularList;
    private int currentPosition;
    private boolean firstCall;

    public CircularListImpl(){
        this.circularList = new ArrayList<>();
        currentPosition = 0;
        firstCall = true;
    }
    @Override
    public void add(int element) {
        circularList.add(element);
    }

    @Override
    public int size() {
        return circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return get(Direction.NEXT);
    }

    @Override
    public Optional<Integer> previous() {
        return get(Direction.PREVIOUS);
    }

    @Override
    public void reset() {
        currentPosition = 0;
        firstCall = true;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return circularList.stream().filter(element -> strategy.apply(element)).findFirst();
    }

    private Optional<Integer> get(Direction direction){
        if (circularList.size() > 0){
            if (firstCall){
                firstCall = false;
                return Optional.of(circularList.get(currentPosition));
            }
            if (direction == Direction.NEXT){
                currentPosition++;
            } else if (direction == Direction.PREVIOUS){
                currentPosition--;
            }
            calculateCurrentPosition();
            var previous = Optional.of(circularList.get(currentPosition));
            return previous;
        }
        return Optional.empty();
    }

    private void calculateCurrentPosition(){
        if (currentPosition >= circularList.size()){
            currentPosition = currentPosition%circularList.size();
        }
        if (currentPosition < 0){
            currentPosition = circularList.size() - 1;
        }
    }
}
