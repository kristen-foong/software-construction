package ca.ubc.cpsc210.colour;

// Represents a colour having a red, green and blue component,
// each of which is in the range [0, 255]
public class Colour {

    int r, g, b;

    // EFFECTS: constructs the colour (r, g, b)
    Colour(int r, int g, int b) {
        // stub
        this.r = r;
        this.g = g;
        this.b = b;
    }

    // EFFECTS: returns true if this colour is on the grey scale,
    // false otherwise
    boolean isGreyScale() {
        // return false;   // stub
        if(r == g && r == b) {
            return true;
        }
        return false;
    }

    // EFFECTS: returns the hexadecimal representation of this colour
    String toHex() {
        // return "0";   // stub
        String hex = Integer.toHexString((r * 256 + g) * 256 + b);

        /*if(hex.length() < 6){
            String zeroes = "";
            for (int i = 0; i < (6 - hex.length()); i++) {
                zeroes += "0";
            }
            hex = zeroes + hex;
        }
        */
        return hex;
    }

    //User-Added Code
    //Getters for r, g, and b values
    //EFFECTS: returns the r value of a color
    int getR() {
        return this.r;
    }

    //EFFECTS: returns the g value of a color
    int getG() {
        return this.g;
    }

    //EFFECTS: returns the b value of a color
    int getB() {
        return this.b;
    }
}
