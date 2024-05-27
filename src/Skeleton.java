import java.util.*;
public class Skeleton {
    private SkeletonGame game;
    Skeleton() {
        game = new SkeletonGame();
    }
    public void run() {
        Scanner sc = new Scanner(System.in);
        int useCase;
        while (true) {
            System.out.println("Skeleton program for Desert of Drukmakor\n" +
                    "Select a Use-case:\n\n" +
                    "1.Player redirects Pump\n" +
                    "2.Mechanic repairs Pump\n" +
                    "3.Mechanic places Pump\n" +
                    "4.Saboteur punctures Pipe\n" +
                    "5.Player moves\n" +
                    "6.Mechanic picks up Pump\n" +
                    "7.Mechanic picks up Pipe\n" +
                    "8.Mechanic places Pump\n" +
                    "9.Game steps\n" +
                    "10.Game starts\n" +
                    "11.Desert steps\n" +
                    "12.Pipe steps\n" +
                    "13.Pump steps\n" +
                    "14.Cistern steps\n" +
                    "15.Sand steps\n" +
                    "16.Spring steps\n" +
                    "17.Mechinc repairs Pipe\n\n" +
                    "0.Exit\n");
            useCase = sc.nextInt();
            if (useCase == 0) {
                break;
            }
            switch(useCase) {
                case 1:
                    System.out.println("Select an alternative run:\n\n" +
                            "Player stands on the Pump, sets the input and output Pipe\n" +
                            "1.There aren't two Pipes\n" +
                            "2.Player doesn't stand on a Pump\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.playerRedirectsPump_1_1();
                            break;
                        case 2:
                            game.playerRedirectsPump_2();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.Mechanic stands on a broken Pump\n" +
                            "2.Mechanic stands on a non-broken Pump\n" +
                            "3.Mechanic doesn't stand on a Pump\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.mechanicRepairsPump_1();
                            break;
                        case 2:
                            game.mechanicRepairsPump_2();
                            break;
                        case 3:
                            game.mechanicRepairsPump_3();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.Doesn't place a Pipe\n" +
                            "2.Places Pipe on an ActiveField\n" +
                            "3.Places Pipe on a full ActiveField\n" +
                            "4.Places Pipe on a Pipe\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.mechanicPlacesPipe_1();
                            break;
                        case 2:
                            game.mechanicPlacesPipe_2();
                            break;
                        case 3:
                            game.mechanicPlacesPipe_3();
                            break;
                        case 4:
                            game.mechanicPlacesPipe_4();
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.Saboteur stands on an ActiveField\n" +
                            "Saboteur stands on a Pipe\n" +
                            "2.Pipe is punctured already\n" +
                            "3.Pipe is not yet punctured\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.saboteurPuncturesPipe_1();
                            break;
                        case 2:
                            game.saboteurPuncturesPipe_2_1();
                            break;
                        case 3:
                            game.saboteurPuncturesPipe_2_2();
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.Player moves to a non-neighbouring Field\n" +
                            "Player moves to a neighbouring Field\n" +
                            "2.If there is a player on the Pipe its unsuccessful\n" +
                            "3.If there aren't any Players on the Pipe its successful\n" +
                            "4.Player steps to neighbouring non-Pipe\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.playerMoves_1();
                            break;
                        case 2:
                            game.playerMoves_2_1();
                            break;
                        case 3:
                            game.playerMoves_2_2();
                            break;
                        case 4:
                            game.playerMoves_3();
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.Mechanic stands on a Cistern\n" +
                            "2.Mechanic doesn't stand on a Cistern\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.mechanicPicksUpPump_1();
                            break;
                        case 2:
                            game.mechanicPicksUpPump_2();
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.Mechanic stands on a Pipe\n" +
                            "2.Mechanic stands on an ActiveField, which doesn't have any Pipes\n" +
                            "3.Mechanic stands on an ActiveField, which has Pipes\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.mechanicPicksUpPipe_1();
                            break;
                        case 2:
                            game.mechanicPicksUpPipe_2();
                            break;
                        case 3:
                            game.mechanicPicksUpPipe_3();
                            break;
                    }
                    break;
                case 8:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.Mechanic stands on an active field\n" +
                            "Mechanic stands on a pipe\n" +
                            "2.Mechanic does not have a pump in his inventory\n" +
                            "Mechanic does have a pump in his inventory\n" +
                            "3.The pipe has water in it\n" +
                            "4.The pipe is empty\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.mechanicPlacesPump_1();
                            break;
                        case 2:
                            game.mechanicPlacesPump_2_1();
                            break;
                        case 3:
                            game.mechanicPlacesPump_2_2_1();
                            break;
                        case 4:
                            game.mechanicPlacesPump_2_2_2();
                            break;
                    }
                    break;
                case 9:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.If the playtime is over, the game has ended\n" +
                            "2.If the playtime is not over, the game continues\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.gameSteps_1();
                            break;
                        case 2:
                            game.gameSteps_2();
                            break;
                    }
                    break;
                case 10:
                    game = new SkeletonGame();
                    game.initialize();
                    break;
                case 11:
                    game.desertSteps_1();
                    break;
                case 12:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.Pipe is not punctured\n" +
                            "2.Pipe is punctured\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.pipeSteps_1();
                            break;
                        case 2:
                            game.pipeSteps_2();
                            break;
                    }
                    break;
                case 13:
                    System.out.println("Select an alternative run:\n\n" +
                            "Pump is not broken\n" +
                            "Pump has output Pipe\n" +
                            "1.Pump has input Pipe\n" +
                            "2.Pump doesn't have input Pipe\n" +
                            "3.Pump doesn't have output Pipe\n" +
                            "4.Pump is broken\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.pumpSteps_1_1_1();
                            break;
                        case 2:
                            game.pumpSteps_1_1_2();
                            break;
                        case 3:
                            game.pumpSteps_1_2();
                            break;
                        case 4:
                            game.pumpSteps_2();
                            break;
                    }
                    break;
                case 14:
                    System.out.println("Select an alternative run:\n\n" +
                            "Cistern has neighbours\n" +
                            "1.Generates Pipe\n" +
                            "2.Doesn't generate Pipe\n" +
                            "Cistern doesn't have neighbours\n" +
                            "3.Generates Pipe\n" +
                            "4.Doesn't generate Pipe\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.cisternSteps_1_1();
                            break;
                        case 2:
                            game.cisternSteps_1_2();
                            break;
                        case 3:
                            game.cisternSteps_2_1();
                            break;
                        case 4:
                            game.cisternSteps_2_2();
                            break;
                    }
                    break;
                case 15:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.Contais water\n" +
                            "2.Doesn't contain water\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.sandSteps_1();
                            break;
                        case 2:
                            game.sandSteps_2();
                            break;
                    }
                    break;
                case 16:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.Spring adds water to neighbours\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.springSteps_1();
                            break;
                    }
                    break;
                case 17:
                    System.out.println("Select an alternative run:\n\n" +
                            "1.Mechanic stands on a broken Pipe\n" +
                            "2.Mechanic stands on a non-broken Pipe\n" +
                            "3.Mechanic doesn't stand on a Pipe\n");
                    useCase = sc.nextInt();
                    switch (useCase) {
                        case 1:
                            game.mechanicRepairsPipe_1();
                            break;
                        case 2:
                            game.mechanicRepairsPipe_2();
                            break;
                        case 3:
                            game.mechanicRepairsPipe_3();
                            break;
                    }
                    break;
            }
        }
    }
}
