package Transmisor;

class Hamming {
	
    static int[] generateCode(int a[]) {
		// We will return the array 'b'.
		int b[];
		
		// We find the number of parity bits required:
		int i=0, parity_count=0 ,j=0, k=0;
		while(i<a.length) {
			// 2^(parity bits) must equal the current position
			// Current position is (number of bits traversed + number of parity bits + 1).
			// +1 is needed since array indices start from 0 whereas we need to start from 1.
			
			if(Math.pow(2,parity_count) == i+parity_count + 1) {
				parity_count++;
			}
			else {
				i++;
			}
		}
		
		// Length of 'b' is length of original data (a) + number of parity bits.
		b = new int[a.length + parity_count];
		
		// Initialize this array with '2' to indicate an 'unset' value in parity bit locations:
		
		for(i=1 ; i<=b.length ; i++) {
			if(Math.pow(2, j) == i) {
				// Found a parity bit location.
				// Adjusting with (-1) to account for array indices starting from 0 instead of 1.
				
				b[i-1] = 2;
				j++;
			}
			else {
				b[k+j] = a[k++];
			}
		}
		for(i=0 ; i<parity_count ; i++) {
			// Setting even parity bits at parity bit locations:
			
			b[((int) Math.pow(2, i))-1] = getParity(b, i);
		}
		return b;
	}
	
	static int getParity(int b[], int power) {
		int parity = 0;
		for(int i=0 ; i < b.length ; i++) {
			if(b[i] != 2) {
				// If 'i' doesn't contain an unset value,
				// We will save that index value in k, increase it by 1,
				// Then we convert it into binary:
				
				int k = i+1;
				String s = Integer.toBinaryString(k);
				
				// Now if the bit at the 2^(power) location of the binary value of index is 1,
				// Then we need to check the value stored at that location.
				// Checking if that value is 1 or 0, we will calculate the parity value.
				
				int x = ((Integer.parseInt(s))/((int) Math.pow(10, power)))%10;
				if(x == 1) {
					if(b[i] == 1) {
						parity = (parity+1)%2;
					}
				}
			}
		}
		return parity;
	}
	
	static String receive(String codigoRecibido, int parity_count) {
		// This is the receiver code. It receives a Hamming code in array 'a'.
		// We also require the number of parity bits added to the original data.
		// Now it must detect the error and correct it, if any.
	
                //transformar el string de codigoRecibido en un int[] para trabajar con el
                String[] binarioPartes = codigoRecibido.split("");
                int a[] = new int[binarioPartes.length];
        
        
                for(int i=0;i<binarioPartes.length;i++){
                a[i] = Integer.parseInt(binarioPartes[i]);
                }
            
            
		int power;
		// We shall use the value stored in 'power' to find the correct bits to check for parity.
		
		int parity[] = new int[parity_count];
		// 'parity' array will store the values of the parity checks.
		
		String syndrome = new String();
		// 'syndrome' string will be used to store the integer value of error location.
		
		for(power=0 ; power < parity_count ; power++) {
			// We need to check the parities, the same number of times as the number of parity bits added.
			
			for(int i=0 ; i < a.length ; i++) {
				// Extracting the bit from 2^(power):
				
				int k = i+1;
				String s = Integer.toBinaryString(k);
				int bit = ((Integer.parseInt(s))/((int) Math.pow(10, power)))%10;
				if(bit == 1) {
					if(a[i] == 1) {
						parity[power] = (parity[power]+1)%2;
					}
				}
			}
			syndrome = parity[power] + syndrome;
		}
		// This gives us the parity check equation values.
		// Using these values, we will now check if there is a single bit error and then correct it.
		
		int error_location = Integer.parseInt(syndrome, 2);
		if(error_location != 0) {
			a[error_location-1] = (a[error_location-1]+1)%2;
			
		}
		
		
		// Finally, we shall extract the original data from the received (and corrected) code:
                
                power = parity_count-1;
		
		for(int i=a.length ; i > 0 ; i--) {
			if(Math.pow(2, power) != i) {
				
			}
			else {  
                                a[i-1]=9;
				power--;
			}
		}
                char entreChar[] = new char[a.length];
                for(int i=0;i<a.length;i++){
                 if(a[i]!=9){
                    entreChar[i] = String.valueOf(a[i]).charAt(0);
            }
        }
                String codigoOriginal= String.valueOf(entreChar);
                return codigoOriginal;
		
        }
}