package pkg.inheritence_상속;

//손자도 가능!
public class a {
	int sa;
}

class b extends a{
}
class c extends a{}

interface X {}
interface Y {}
interface Z extends X {}

class d extends b implements Z,Y{
	int sd;
}
class e extends c{}
