package hqh.annotations.ormapping;

public @interface Uniqueness {
	Constraints constraints()
	default @Constraints(unique=true);
}
