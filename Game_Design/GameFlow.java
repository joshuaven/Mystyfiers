import java.util.Scanner;

// a class that contains the choices and how the game progresses
public class GameFlow {
	RoomDesign rooms;
	PuzzleDesign puzzles;
	int current;

	GameFlow() {
		this.rooms = new RoomDesign(5);
		this.puzzles = new PuzzleDesign(rooms);
		this.current = 0;
		choices();
	}

	private void choices() {
		for (int i = current; rooms.roomDes[i].roomNumber != -1; i++) {
			puzzles.puzzDes[i].viewScript();
			Scanner in = new Scanner(System.in);
			System.out.print("> ");
			String command = in.nextLine();
			switch (command.toLowerCase()) {
			case "look":
				System.out.println("The room consists of:");
				rooms.roomDes[i].viewItems();
				choices();
				break;
			case "examine":
				System.out.println("There's a note on the table saying 'You must escape the room or else...'");
				break;
			case "inventory":
				System.out.println("You have: ");
				choices();
				break;
			case "get":
				System.out.println("You have gotten the object");
				break;
			case "read":
				System.out.println("You are reading...");
				break;
			case "help":
				System.out.println("Help Basic Commands are look, examine, inventory, get, read...");
				choices();
				break;
			case "":
				System.out.println("I beg your pardon?");
				choices();
				break;
			default:
				System.out.println("That's not a verb I recognize.");
				choices();
				break;		
			}
			in.close();
			this.current = current + 1;
		}
	}

	public static void main(String[] args) {
		new GameFlow();
	}
}