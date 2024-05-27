import java.util.ArrayList;

public class SkeletonGame extends Game {

    public void initialize() {
        //System.out.println("\"Game.initialize\" function called");
        Spring s = new Spring();
        Pipe p1 = new Pipe();
        Pipe p2 = new Pipe();
        Pipe p3 = new Pipe();
        Pump pu = new Pump();
        Cistern c = new Cistern();
        Sand sa = new Sand();

        s.addNeighbour(p1);
        p1.addNeighbour(s);
        p1.addNeighbour(pu);
        pu.addNeighbour(p1);
        pu.addNeighbour(p2);
        p2.addNeighbour(pu);
        p2.addNeighbour(sa);
        sa.addNeighbour(p2);
        pu.addNeighbour(p3);
        p3.addNeighbour(pu);
        pu.addNeighbour(c);
        c.addNeighbour(pu);

        addField(s);
        addField(p1);
        addField(p2);
        addField(p3);
        addField(pu);
        addField(c);
        addField(sa);

        Mechanic m1 = new Mechanic();
        Mechanic m2 = new Mechanic();
        Saboteur s1 = new Saboteur();
        Saboteur s2 = new Saboteur();

        addPlayer(m1);
        addPlayer(m2);
        addPlayer(s1);
        addPlayer(s2);
    }

    public void playerRedirectsPump_1_1() {
        Mechanic m = new Mechanic();
        Pump p = new Pump();
        m.setCurrentField(p);
        m.redirectPump(new Pipe(), new Pipe());
    }
    public void playerRedirectsPump_2() {
        Mechanic m = new Mechanic();
        Pipe p = new Pipe();
        m.setCurrentField(p);
        m.redirectPump(new Pipe(), new Pipe());
    }
    public void mechanicRepairsPump_1() {
        Mechanic m = new Mechanic();
        Pump p = new Pump();
        p.break_();
        m.setCurrentField(p);
        m.repair();
    }
    public void mechanicRepairsPump_2() {
        Mechanic m = new Mechanic();
        Pump p = new Pump();
        m.setCurrentField(p);
        m.repair();
    }
    public void mechanicRepairsPump_3() {
        Mechanic m = new Mechanic();
        Pipe p = new Pipe();
        m.setCurrentField(p);
        m.repair();
    }
    public void mechanicPlacesPipe_1(){
        Mechanic m = new Mechanic();
        Pump p = new Pump();
        m.setCurrentField(p);
        m.placePipe();
    }
    public void mechanicPlacesPipe_2(){
        Mechanic m = new Mechanic();
        Pump p = new Pump();
        m.setCurrentField(p);
        m.placePipe();
    }
    public void mechanicPlacesPipe_3(){
        Mechanic m = new Mechanic();
        Pump p = new Pump();
        m.setCurrentField(p);
        m.placePipe();
    }
    public void mechanicPlacesPipe_4(){
        Mechanic m = new Mechanic();
        Pipe p = new Pipe();
        m.setCurrentField(p);
        m.placePipe();
    }

    public void mechanicPlacesPump_2_2_1(){

    }
    public void mechanicPlacesPump_2_1(){

    }
    public void mechanicPlacesPump_1(){

    }
    public void mechanicPlacesPump_2_2_2(){

    }

    public void saboteurPuncturesPipe_1(){
        Saboteur s = new Saboteur();
        Pump p = new Pump();
        s.setCurrentField(p);
        s.puncture();
    }
    public void saboteurPuncturesPipe_2_1(){
        Saboteur s = new Saboteur();
        Pipe p = new Pipe();
        p.puncture();
        s.setCurrentField(p);
        s.puncture();
    }
    public void saboteurPuncturesPipe_2_2(){
        Saboteur s = new Saboteur();
        Pump p = new Pump();
        s.setCurrentField(p);
        s.puncture();
    }

    public void playerMoves_1(){
        Mechanic m = new Mechanic();
        Pump pu = new Pump();
        Pipe pi = new Pipe();
        m.setCurrentField(pu);
        m.move(pi);
    }
    public void playerMoves_2_1(){
        Mechanic m = new Mechanic();
        Pump pu = new Pump();
        Pipe pi = new Pipe();
        pu.addNeighbour(pi);
        pi.addNeighbour(pu);
        m.setCurrentField(pu);
        m.move(pi);
    }
    public void playerMoves_2_2(){
        Mechanic m = new Mechanic();
        Pump pu = new Pump();
        Pipe pi = new Pipe();
        pu.addNeighbour(pi);
        pi.addNeighbour(pu);
        m.setCurrentField(pu);
        m.move(pi);
    }
    public void playerMoves_3(){
        Mechanic m = new Mechanic();
        Pump pu = new Pump();
        Pipe pi = new Pipe();
        m.setCurrentField(pi);
        m.move(pu);
    }
    public void mechanicPicksUpPump_1(){
        Mechanic m = new Mechanic();
        Cistern c = new Cistern();
        m.setCurrentField(c);
        m.pickUpPump();
    }
    public void mechanicPicksUpPump_2(){
        Mechanic m = new Mechanic();
        Pump p = new Pump();
        m.setCurrentField(p);
        m.pickUpPump();
    }
    public void mechanicPicksUpPipe_1(){
        Mechanic m = new Mechanic();
        Pipe pi = new Pipe();
        Pump pu = new Pump();
        pi.addNeighbour(pu);
        pu.addNeighbour(pi);
        m.setCurrentField(pi);
        m.pickUpPipe(pi);
    }
    public void mechanicPicksUpPipe_2(){
        Mechanic m = new Mechanic();
        Pipe pi = new Pipe();
        Pump pu = new Pump();
        pi.addNeighbour(pu);
        pu.addNeighbour(pi);
        m.setCurrentField(pi);
        m.pickUpPipe(pi);
    }
    public void mechanicPicksUpPipe_3(){

    }
    public void gameSteps_1(){
        step();
    }
    public void gameSteps_2(){
        step();
    }
    public void desertSteps_1(){
        Pipe pi = new Pipe();
        Pump pu = new Pump();
        pi.addNeighbour(pu);
        pu.addNeighbour(pi);
        ArrayList<Field> fields = new ArrayList<>();
        fields.add(pi);
        fields.add(pu);
        Desert d = new Desert(fields);
        d.step();
    }
    public void gameStarts_1(){
        initialize();
    }
    public void pipeSteps_1(){
        Pipe p = new Pipe();
        p.step();
    }
    public void pipeSteps_2(){
        Pipe p = new Pipe();
        p.puncture();
        p.step();
    }
    public void pumpSteps_1_1_1(){
        Pump p = new Pump();
        Pipe pi = new Pipe();
        Pipe pi2 = new Pipe();
        p.redirect(pi, pi2);
        p.step();
    }
    public void pumpSteps_1_1_2(){
        Pump p = new Pump();
        p.step();
    }
    public void pumpSteps_1_2(){
        Pump p = new Pump();
        p.step();
    }
    public void pumpSteps_2(){
        Pump p = new Pump();
        p.break_();
        p.step();
    }
    public void cisternSteps_1_1(){
        Cistern c = new Cistern();
        Pipe p = new Pipe();
        c.addNeighbour(p);
        c.generatePipe();
        c.step();
    }
    public void cisternSteps_1_2(){
        Cistern c = new Cistern();
        Pipe p = new Pipe();
        c.addNeighbour(p);
        c.step();
    }
    public void cisternSteps_2_1(){
        Cistern c = new Cistern();
        c.generatePipe();
        c.step();
    }
    public void cisternSteps_2_2(){
        Cistern c = new Cistern();
        c.step();
    }
    public void sandSteps_1(){
        Sand s = new Sand();
        s.step();
    }
    public void sandSteps_2(){
        Sand s = new Sand();
        s.addWater();
        s.step();
    }
    public void springSteps_1(){
        Spring s = new Spring();
        s.step();
    }
    public void mechanicRepairsPipe_1(){
        Mechanic m = new Mechanic();
        Pipe p = new Pipe();
        m.setCurrentField(p);
        p.puncture();
        m.repair();
    }
    public void mechanicRepairsPipe_2(){
        Mechanic m = new Mechanic();
        Pipe p = new Pipe();
        m.setCurrentField(p);
        m.repair();
    }
    public void mechanicRepairsPipe_3(){
        Mechanic m = new Mechanic();
        Pump p = new Pump();
        m.setCurrentField(p);
        m.repair();
    }
}
