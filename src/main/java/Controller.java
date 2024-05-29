public class Controller {

    private final Timer timer;
    private final Model model;
    private final View view;
    public Controller() {
        model = new Model(2, 2);
        view = new View(this);
        timer = new Timer(model);
        updateView();
    }

    public Controller(int numberOfSaboteurs, int numberOfMechanics){
        model = new Model(numberOfSaboteurs, numberOfMechanics);
        view = new View(this);
        timer = new Timer(model);
        updateView();
    }

    public boolean move(String moveToFieldName){
      Field to = model.getFieldByName(moveToFieldName);
      boolean success = model.getActivePlayer().move(to);
      if(success) {
          timer.tick();
          updateView();
      }
      return success;
    }

    public boolean repair(){
        boolean success = model.getActivePlayer().repair();
        if(success)
            updateView();
        return success;
    }

    public boolean _break(){
        boolean success = model.getActivePlayer().puncture();
        if(success)
            updateView();
        return success;
    }

    public boolean makeSticky(){
        boolean success = model.getActivePlayer().makeSticky();
        if(success)
            updateView();
        return success;
    }

    public boolean makeSlippery(){
        boolean success = model.getActivePlayer().makeSlippery();
        if(success)
            updateView();
        return success;
    }

    public boolean placePipe(){
        boolean success = model.getActivePlayer().placePipe();
        if (success)
            updateView();
        return success;
    }

    public boolean placePump(){
        var pump = model.getActivePlayer().getPickedUpPump();
        boolean success = model.getActivePlayer().placePump();
        if (success){
            model.placeInWorld(pump);
            updateView();
        }
        return success;
    }

    public boolean redirectPump(String inFieldName, String outFieldName){
        Field in = model.getFieldByName(inFieldName);
        Field out = model.getFieldByName(outFieldName);
        boolean success = model.getActivePlayer().redirectPump(in, out);
        if(success)
            updateView();
        return success;
    }

    public boolean pickUpPump(){
        boolean success = model.getActivePlayer().pickUpPump();
        return success;
    }

    public boolean pickUpPipe(String pipeFieldName){
        Field pipe = model.getFieldByName(pipeFieldName);
        boolean success = model.getActivePlayer().pickUpPipe(pipe);
        if(success)
            updateView();
        return success;
    }

    public boolean pass(){
        timer.tick();
        updateView();
        return true;
    }

    public String getActivePlayerName(){
        return model.getActivePlayer().getName();
    }

    public int getSaboteurPoints(){
        return model.getPointCounter().getSaboteurPoints();
    }

    public int getMechanicPoints(){
        return model.getPointCounter().getMechanicPoints();
    }

    public void updateView(){
        view.update(model.getFieldDescriptions(), model.getPlayerDescriptions());
    }

}
