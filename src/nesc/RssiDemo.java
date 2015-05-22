/*
 * "Copyright (c) 2005 The Regents of the University  of California.  
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software and
 * its documentation for any purpose, without fee, and without written
 * agreement is hereby granted, provided that the above copyright
 * notice, the following two paragraphs and the author appear in all
 * copies of this software.
 * 
 * IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY
 * PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL
 * DAMAGES ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS
 * DOCUMENTATION, EVEN IF THE UNIVERSITY OF CALIFORNIA HAS BEEN
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
 * AND FITNESS FOR A PARTICULAR PURPOSE.  THE SOFTWARE PROVIDED HEREUNDER IS
 * ON AN "AS IS" BASIS, AND THE UNIVERSITY OF CALIFORNIA HAS NO OBLIGATION TO
 * PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS."
 *
 */

/*
 * This is a modified version of TestSerial.java, from apps/tests/TestSerial
 * from TinyOS 2.x (www.tinyos.net)
 */

/**
 * Java-side application for testing the RSSI demo
 *
 * @author Phil Levis <pal@cs.berkeley.edu>
 * @author Dimas Abreu Dutra <dimas@dcc.ufmb.br>
 * @date April 11 2008
 */

import java.io.IOException;

import net.tinyos.message.*;
import net.tinyos.packet.*;
import net.tinyos.util.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

//TIMER
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

 interface stopable
 {
	public void stop();
 }



public class RssiDemo implements MessageListener,stopable {

  public MoteIF moteIF;
  static  String source = null;
  static MoteIF mif;
  public Data data;
  static PhoenixSource phoenix;
  static int count;
  
  //
  
 
  
  public RssiDemo(MoteIF moteIF) {
    this.moteIF = moteIF;
	data = new Data();
    this.moteIF.registerListener(data, this);
  }
    
  public void messageReceived(int to, Message message) {
    Data msg = (Data) message;
    int source = message.getSerialPacket().get_header_src();
	
	System.out.println(source + "," +  msg.get_rssi()+ "," +msg.get_car_id()+ "," +msg.get_node_id()+ "," +(char)msg.get_direction());
	

  }
  
  private static void usage() {
    System.err.println("usage: RssiDemo [-comm <source>]");
  }
  
  public static void main(String[] args) throws Exception 
  {
		if (args.length == 2) {
			if (!args[0].equals("-comm")) {
				usage();
				System.exit(1);
			}
		source = args[1];
		}
		else if (args.length != 0) {
			usage();
			System.exit(1);
		}
	
		
	
	
		if (source == null) {
			phoenix = BuildSource.makePhoenix(PrintStreamMessenger.err);
		}
		else {
			phoenix = BuildSource.makePhoenix(source, PrintStreamMessenger.err);
		}
		
		
		//System.out.print("Enter time as min:sec: ");
		//String in = new Scanner(System.in).nextLine();
		
		//int secs = Integer.parseInt(in) * 60;
		
	 
		mif = new MoteIF(phoenix);
		RssiDemo serial = new RssiDemo(mif);
		
		new ReminderBeep(2*60,serial);
		
		
		
		//serial.moteIF.deregisterListener(serial.m, serial);
		//phoenix.shutdown();
		
	
		
	}
	public void stop()
	{
		try{
		phoenix.getPacketSource().close();
		}
		catch(Exception ex)
		{
			
		}
	}
  
 }
//Timer
  class ReminderBeep {
  Toolkit toolkit;
  Timer timer;

  public ReminderBeep(int seconds,stopable obj) {
    toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
	
    timer.schedule(new RemindTask(obj), seconds * 1000);
	
  }

  class RemindTask extends TimerTask {
	stopable obj;
	RemindTask(stopable obj)
	{
		this.obj = obj;
	}
    public void run() {
    
	  obj.stop();
      toolkit.beep();
      timer.cancel(); //Not necessary because we call System.exit
	  System.exit(0);
    }
  }
  }

