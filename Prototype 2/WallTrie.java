import java.util.*;

public class WallTrie 
{
    // Declare variables
    Map<Integer, Map<Integer, Wall>>[] trie;

    private final int VERTICAL = 0;
    private final int HORIZONTAL = 1;

    // Constructor
    public WallTrie(int order)
    {
        trie = (Map<Integer, Map<Integer, Wall>>[]) new HashMap[2];
    }

    // Methods
    public void add(Wall wall)
    {
        int type = wall.getType() == Wall.Type.HORIZONTAL? HORIZONTAL: VERTICAL;

        if(trie[type] == null)
        {
            trie[type] = new HashMap<Integer, Map<Integer, Wall>>();
        }

        trie[type]
            .computeIfAbsent(wall.getCol(), c -> new HashMap<Integer, Wall>())
            .putIfAbsent(wall.getRow(), wall);
    }

    public boolean contains(Wall wall)
    {
        int type = wall.getType() == Wall.Type.HORIZONTAL? HORIZONTAL: VERTICAL;

        Map<Integer, Map<Integer, Wall>> typeLayer = trie[type];
        if(typeLayer == null) return false;

        Map<Integer, Wall> colLayer = typeLayer.get(wall.getCol());
        if(colLayer == null) return false;

        Wall rowLayer = colLayer.get(wall.getRow());
        if(rowLayer == null) return false;

        return true;
    }

    public List<Wall> toList()
    {
        List<Wall> toArray = new ArrayList<Wall>();

        for(Map<Integer, Wall> element: trie[1].values())
        {
            for(Wall wall: element.values())
            {
                toArray.add(wall);
            }
        }

        return toArray;
    }
}
