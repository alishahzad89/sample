package com.mycompany.core;

import org.openqa.grid.selenium.GridLauncherV3;

public class GridHubNodeConfig {

	public static boolean isHubRunning = false;
	public static boolean isNodeRunning = false;

	public static synchronized void startHub() {

		if (!isHubRunning) {
			try {
				System.out.println("starting hub");

				GridLauncherV3.main(new String[] { "-role", "hub" });
				System.out.println("hub started");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public static synchronized void startNode() {

		if (!isNodeRunning) {
			try {
				System.out.println("starting node");
				GridLauncherV3.main(new String[] { "-role", "node" });
				System.out.println("node started");
				isNodeRunning = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
