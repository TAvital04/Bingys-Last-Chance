import java.util.*;

public class PathTrie 
{
    // Variables
        Map<Integer, Map<Integer, Path>>[] trie;

        private final int VERTICAL = 0;
        private final int HORIZONTAL = 1;

    // Constructor
        public PathTrie(int order)
        {
            trie = (Map<Integer, Map<Integer, Path>>[]) new HashMap[2];
        }

    // Methods
        public void add(Path path)
        {
            int type = getTypeIndex(path.getType());

            if(trie[type] == null)
            {
                trie[type] = new HashMap<Integer, Map<Integer, Path>>();
            }

            trie[type]
                .computeIfAbsent(path.getCol(), c -> new HashMap<Integer, Path>())
                .putIfAbsent(path.getRow(), path);
        }

        public boolean contains(Path path)
        {
            int type = getTypeIndex(path.getType());

            Map<Integer, Map<Integer, Path>> typeLayer = trie[type];
            if(typeLayer == null) return false;

            Map<Integer, Path> colLayer = typeLayer.get(path.getCol());
            if(colLayer == null) return false;

            Path rowLayer = colLayer.get(path.getRow());
            if(rowLayer == null) return false;

            return true;
        }

        public List<Path> toList()
        {
            List<Path> toArray = new ArrayList<Path>();

            for(Map<Integer, Path> element: trie[0].values())
            {
                for(Path path: element.values())
                {
                    toArray.add(path);
                }
            }

            for(Map<Integer, Path> element: trie[1].values())
            {
                for(Path path: element.values())
                {
                    toArray.add(path);
                }
            }

            return toArray;
        }

    // Getters/setters
        public int getTypeIndex(Path.Type type)
        {
            int result = type == Path.Type.HORIZONTAL? HORIZONTAL: VERTICAL;
            return result;
        }

        public Path getPath(Path path)
        {
            Map<Integer, Map<Integer, Path>> type = trie[getTypeIndex(path.getType())];
            if(type != null)
            {
                Map<Integer, Path> col = type.get(path.getCol());
                if(col != null)
                {
                    Path row = col.get(path.getRow());
                    if(row != null)
                    {
                        return row;
                    }
                }
            }

            return null;
        }
}
