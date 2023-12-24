from z3 import Real, Solver

hailstones = []

with open("day24.txt") as file:
    for line in file:
        pos, vel = line.split("@")
        x, y, z = [int(x) for x in pos.split(", ")]
        vx, vy, vz = [int(x) for x in vel.split(", ")]
        hailstones.append((x, y, z, vx, vy, vz))


x, y, z, vx, vy, vz = (
    Real("x"),
    Real("y"),
    Real("z"),
    Real("vx"),
    Real("vy"),
    Real("vz"),
)

solver = Solver()

for i, (ax, ay, az, vax, vay, vaz) in enumerate(hailstones[:3]):
    t = Real(f"t_{i}")
    solver.add(x + vx * t == ax + vax * t)
    solver.add(y + vy * t == ay + vay * t)
    solver.add(z + vz * t == az + vaz * t)

solver.check()

model = solver.model()
print(model.eval(x + y + z))
