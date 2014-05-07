package files.out;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import algorithms.bitshift.BitShift;

public class BitFileWriter {
	
	private BufferedWriter bw;
	private boolean[] bitBuffer = new boolean[8];
	private int pos = 0;
	
	public BitFileWriter(FileWriter fw){
		this.bw = new BufferedWriter(fw);
	}
	
	public void writeBit(boolean bit){
		if(this.pos >= 8){
			writeByte();
			this.pos = 0;
		}
		bitBuffer[this.pos++] = bit;
	}

	private void writeByte() {
		try {
			bw.write(BitShift.booleanArrayToByte(bitBuffer));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void endStream(){
		closeWriter();
	}
	
	@Override
	protected void finalize() throws Throwable {
		closeWriter();
		super.finalize();
	}
	
	private void closeWriter(){
		if(bw != null){
			try{
				bw.flush();
				bw.close();
				bw = null;
			}catch (IOException ieo){
				ieo.printStackTrace();
			}
		}
	}
	
	
	
}
