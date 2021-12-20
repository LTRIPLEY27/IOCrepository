/* This file is part of the db4o object database http://www.db4o.com

Copyright (C) 2004 - 2011  Versant Corporation http://www.versant.com

db4o is free software; you can redistribute it and/or modify it under
the terms of version 3 of the GNU General Public License as published
by the Free Software Foundation.

db4o is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
for more details.

You should have received a copy of the GNU General Public License along
with this program.  If not, see http://www.gnu.org/licenses/. */
package com.db4o.cs.internal;

import com.db4o.cs.internal.messages.*;
import com.db4o.foundation.*;

/**
 * @exclude
 */
public class ClientAsynchronousMessageProcessor implements Runnable {
	
	private final BlockingQueue _messageQueue;
	
	private boolean _stopped;
	
	public ClientAsynchronousMessageProcessor(BlockingQueue messageQueue){
		_messageQueue = messageQueue;
	}
	
	public void run() {
		while(! _stopped){
			try {
				ClientSideMessage message = (ClientSideMessage) _messageQueue.next();
				if(message != null){
					message.processAtClient();
				}
			} catch (BlockingQueueStoppedException e) {
				break;
			}
		}
	}
	
	public void stopProcessing(){
		_stopped = true;
	}
}
