import java.util.*;
import javafx.scene.Node;

public abstract class Actor extends javafx.scene.image.ImageView{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public abstract void act();

	public void move(double dx, double dy) {
		setX(getX()+dx);
		setY(getY()+dy);
	}
	
	public World getWorld() {
		return (World)getParent();
	}
	
	public double getWidth() {
		return getBoundsInParent().getWidth();
	}
	
	public double getHeight() {
		return getBoundsInParent().getHeight();
	}
	
	public double getCenterX()
	{
		return getX() + getWidth()/2;
	}
	public double getCenterY()
	{
		return getY() + getHeight()/2;
	}
	
	public <A extends Actor>List<A> getIntersectingObjects(java.lang.Class<A> cls) {
		ArrayList<A>list=new ArrayList<>();
		for(Node n : getWorld().getChildren()) {
			if(n!=this && cls.isInstance(n) && n.intersects(getBoundsInParent())) {
				list.add(cls.cast(n));
			}
		}
		return list;
	}
	
	public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
		for(Node n : getWorld().getChildren()) {
			if(n!=this && cls.isInstance(n) && n.intersects(getBoundsInParent())) {
				return cls.cast(n);
			}
		}
		return null;
	}
}