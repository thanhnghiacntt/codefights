/*
Consider a special family of Engineers and Doctors. This family has the following rules:

Everybody has two children.
The first child of an Engineer is an Engineer and the second child is a Doctor.
The first child of a Doctor is a Doctor and the second child is an Engineer.
All generations of Doctors and Engineers start with an Engineer.
We can represent the situation using this diagram:

                E
           /         \
          E           D
        /   \        /  \
       E     D      D    E
      / \   / \    / \   / \
     E   D D   E  D   E E   D
Given the level and position of a person in the ancestor tree above, find the profession of the person.
Note: in this tree first child is considered as left child, second - as right.
*/

String findProfession(int level, int pos) {
    pos = (pos - 1) % (1 << level - 1) + 1;
    if (isDoctor(level, pos)) {
        return "Doctor";
    }
    return "Engineer";
}

boolean isDoctor(int level, int pos) {
    switch (level) {
    case 1:
        return false;
    case 2:
        if (pos == 1) {
            return false;
        }
        return true;
    default:
        if (pos % 2 == 0) {
            return !isDoctor(level - 1, (int) Math.ceil(pos * 1.0 / 2));
        } else {
            return isDoctor(level - 1, (int) Math.ceil(pos * 1.0 / 2));
        }
    }
}