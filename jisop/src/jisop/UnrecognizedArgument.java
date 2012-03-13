package jisop;

/**
 *
 * @author mathieu
 */
public class UnrecognizedArgument {
    public final int index;
    public final String value;
    public UnrecognizedArgument(int index, String value) {
        this.index = index;
        this.value = value;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.index;
        hash = 41 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnrecognizedArgument other = (UnrecognizedArgument) obj;
        if (this.index != other.index) {
            return false;
        }
        if ((this.value == null) ? (other.value != null) : !this.value.equals(other.value)) {
            return false;
        }
        return true;
    }

}
