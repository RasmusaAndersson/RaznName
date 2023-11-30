

public class NameRepository {
    private static String[] names = new String[0];

    public static int getSize() {
        return names.length;
    }

    public static void setNames(String[] names) {
        NameRepository.names = names;
    }

    public static void clear() {
        NameRepository.names = new String[0];
    }

    public static String[] findAll() {
        return NameRepository.names;
    }

    public static String find(final String fullName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equals(fullName)) {
                return names[i];
            }
        }
        return null;
    }

    public static boolean add(final String fullName) {
        String[] newNames = new String[names.length + 1];
        for (int i = 0; i < names.length; i++) {
            newNames[i] = names[i];
        }
        newNames[names.length] = fullName;
        names = newNames;
        return true;
    }

    public static String[] findByFirstName(final String firstName) {
        String[] matches = new String[0];
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].startsWith(firstName)) {
                String[] newMatches = new String[matches.length + 1];
                for (int j = 0; j < matches.length; j++) {
                    newMatches[j] = matches[j];
                }
                newMatches[matches.length] = names[i];
                matches = newMatches;
            }
        }
        return matches;
    }

    public static String[] findByLastName(final String lastName) {
        String[] matches = new String[0];
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].endsWith(lastName)) {
                String[] newMatches = new String[matches.length + 1];
                for (int j = 0; j < matches.length; j++) {
                    newMatches[j] = matches[j];
                }
                newMatches[matches.length] = names[i];
                matches = newMatches;
            }
        }
        return matches;
    }

    public static boolean update(final String original, final String updatedName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equals(original)) {
                if (names[i].equals(updatedName)) {
                    return false;
                }
                for (int j = 0; j < names.length; j++) {
                    if (names[j] != null && names[j].equals(updatedName)) {
                        return false;
                    }
                }
                names[i] = updatedName;
                return true;
            }
        }
        return false;
    }

    public static boolean remove(final String fullName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equals(fullName)) {
                String[] newNames = new String[names.length - 1];
                for (int j = 0, k = 0; j < names.length; j++) {
                    if (j != i) {
                        newNames[k++] = names[j];
                    }
                }
                names = newNames;
                return true;
            }
        }
        return false;
    }
}