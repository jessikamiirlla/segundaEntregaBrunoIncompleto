package so.cpu;

import java.util.List;
import java.util.TimerTask;

import so.SubProcess;

public class CpuManager {
	private Core[] cores;
	
	public static int CAPACITY = 7;
	public static int NUM_OF_CORES - 4;
	public static int CLOCK - 1000;
	
	public CpuManager(); {
		this.cores = new Core[NUM_OF_CORES];
		for (int i = 0; i < this.cores.length; i++) {
			this.cores[i] = new Core(i, CAPACITY);
			
		}
		
		clock();
		
	}
	
	public void registerProcess(int coreIndex, SubProcess sp) {
		this.cores[coreIndex].setCurrentSubProcess(sp);
		
	}
	
	public void Clock () {
		new Timer().scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				executeProcesses();
				
			}
		}, 0, CLOCK);
	}
	
	private void executeProcesses() {
		for (Core core: this.cores) {
			if (core.getCurrentSubProcess() != null) {
				core.run();
			}
			
		}
	}		
			
		
	

	public Core[] getCores() {
		return this.cores;
		
	}

}
