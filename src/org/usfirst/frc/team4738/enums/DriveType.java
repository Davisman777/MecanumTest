package org.usfirst.frc.team4738.enums;

import org.usfirst.frc.team4738.util.Mathd;
import org.usfirst.frc.team4738.wrapper.Axes;

public enum DriveType {
	
	MECANUM_PARABOLIC {
		@Override
		public double[] getDriveVars(Axes leftStick, Axes rightStick) {
			Axes leftStickC = Mathd.curveAxes(leftStick);
			Axes rightStickC = Mathd.curveAxes(rightStick);
			double[] speeds = {
				leftStickC.getY() * Math.sin(rightStickC.getX() + Math.PI/4) + leftStickC.getX(),
				leftStickC.getY() * Math.cos(rightStickC.getX() + Math.PI/4) - leftStickC.getX(),
				leftStickC.getY() * Math.cos(rightStickC.getX() + Math.PI/4) + leftStickC.getX(),
				leftStickC.getY() * Math.sin(rightStickC.getX() + Math.PI/4) - leftStickC.getX(),
			};
			return speeds;
		}
	},
	MECANUM_LINEAR {
		@Override
		public double[] getDriveVars(Axes leftStick, Axes rightStick) {
			double[] speeds = {
				leftStick.getY() * Math.sin(rightStick.getX() + Math.PI/4) + leftStick.getX(),
				leftStick.getY() * Math.cos(rightStick.getX() + Math.PI/4) - leftStick.getX(),
				leftStick.getY() * Math.cos(rightStick.getX() + Math.PI/4) + leftStick.getX(),
				leftStick.getY() * Math.sin(rightStick.getX() + Math.PI/4) - leftStick.getX(),
			};
			return speeds;
		}
	},
	ARCADE_LINEAR {
		@Override
		public double[] getDriveVars(Axes leftStick, Axes rightStick) {
			double[] speeds = {
					leftStick.getX()+leftStick.getY(),
					leftStick.getX()-leftStick.getY(),
					leftStick.getX()+leftStick.getY(),
					leftStick.getX()-leftStick.getY()
			};
			return speeds;
		}
	},
	ARCADE_PARABOLIC {
		@Override
		public double[] getDriveVars(Axes leftStick, Axes rightStick) {
			double[] speeds = {
					Mathd.curve(leftStick.getX()) + Mathd.curve(leftStick.getY()),
					Mathd.curve(leftStick.getX()) - Mathd.curve(leftStick.getY()),
					Mathd.curve(leftStick.getX()) + Mathd.curve(leftStick.getY()),
					Mathd.curve(leftStick.getX()) - Mathd.curve(leftStick.getY())
			};
			
			return speeds;
		}
	},
	TANK_LINEAR {
		@Override
		public double[] getDriveVars(Axes leftStick, Axes rightStick) {
			double[] speeds = {
					leftStick.getY(),
					rightStick.getY(),
					leftStick.getY(),
					rightStick.getY()
			};
			return speeds;
		}
	},
	TANK_PARABOLIC {
		@Override
		public double[] getDriveVars(Axes leftStick, Axes rightStick) {
			double[] speeds = {
					Mathd.curve(leftStick.getY()),
					Mathd.curve(rightStick.getY()),
					Mathd.curve(leftStick.getY()),
					Mathd.curve(rightStick.getY())
			};
			return speeds;
		}
	};
	
	public abstract double[] getDriveVars(Axes leftStick, Axes rightStick);	
}
