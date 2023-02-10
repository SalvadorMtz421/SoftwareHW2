package crm;
// Simple command-line program to assign leads to users

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class AssignLeads {
	public final static int QUIT = 0,
			ADDLEAD = 1,
			ADDUSER = 2,
			ASSIGN = 3,
			DISPLAY = 4;
	public final static String[] CMDS = {
			QUIT + ". Quit",
			ADDLEAD + ". Add a lead",
			ADDUSER + ". Add a user",
			ASSIGN + ". Assign leads",
			DISPLAY + ". Display leads"
	};
	public final static Scanner stdin = new Scanner(System.in);


	public static void main(String[] args) {
		List<Lead> leads = new ArrayList<>();
		Queue<User> users = new ArrayDeque<>();
		System.out.println("Program to assign leads to users");

		int nextcmd = -1;
		while (nextcmd != QUIT) {

			for (String cmd: CMDS) {
				System.out.println(cmd);
			}
			System.out.println("Please choose a cmd (0-" + Integer.toString(CMDS.length-1) + "): ");
			nextcmd = stdin.nextInt();
			stdin.nextLine();	// skip newline after the int
			
			switch(nextcmd) {
			case QUIT:	break;
			case ADDLEAD:
				addLead(leads);
				break;
			case ADDUSER:
				addUser(users);
				break;
			case ASSIGN:
				assignLeadsToUsers(leads, users);
				break;
			case DISPLAY:
				displayLeads(leads);
				break;
			}
		}
		stdin.close();
	}

	private static void displayLeads(List<Lead> leads) {
		System.out.println("Name\t\tCountry\tEmail\t\tAssigned User");
		System.out.println("-----------------------------------------------------------------");
		for (Lead lead : leads) {
			System.out.println(lead);
		}
		
	}

	// For each lead who has not been assigned to a user yet, choose the next user who is online
	private static void assignLeadsToUsers(List<Lead> leads, Queue<User> users) {
		for (Lead lead : leads) {
			for (User user : users) {
				if (lead.getAssigned() == null && user.getOnline()) {
					user.assign(lead);
					lead.setAssigned(user);
					users.remove(user);
					users.add(user);
					break;
				}
			}
		}
		
	}

	// Add a user to the end of the queue
	private static void addUser(Queue<User> users) {
		String name;
		boolean online;
		System.out.println("Please enter a name for the user: ");
		name = stdin.nextLine();
		
		User user = new User(name);
		System.out.print("Is the user online? (true/false) ");
		online = stdin.nextBoolean();
		user.setOnline(online);
		users.add(user);
	}

	// Add a lead to the list of leads
	private static void addLead(List<Lead> leads) {
		String name, email, country, industry;
		System.out.print("Please enter a name for the lead: ");
		name = stdin.nextLine();
		System.out.print("Please enter an email contact for the lead: ");
		email = stdin.nextLine();
		System.out.print("Please enter the country where the lead is located: ");
		country = stdin.nextLine();
		System.out.print("Please enter the industry the lead is in:  ");
		industry = stdin.nextLine();
		leads.add(new Lead(name, email, country, industry));
	}

}
