package files.in;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import algorithms.bitshift.BitShift;

public class BitFileReader {
	
	private BufferedReader br;
	private int buffer;
	private int posInBuffer = 8;
	private boolean[] bufferBits;
	
	public BitFileReader(FileReader fr){
		this.br = new BufferedReader(fr);
	}
	
	public boolean readNextBit() throws IOException, EndOfFileException{
		if(posInBuffer >= 8){
			this.buffer = br.read();
			if(this.buffer == -1){
				throw new EndOfFileException();
			}else{
				this.bufferBits = BitShift.byteToBooleanArray(buffer);
				posInBuffer = 0;
			}
		}
		return bufferBits[posInBuffer++];
	}
	
}
