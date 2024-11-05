import { Component } from '@angular/core';
import { RobotService } from '../services/robot.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-robot-control',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './robot-control.component.html',
  styleUrl: './robot-control.component.css'
})
export class RobotControlComponent {
  moves: string = '';
  response: string | undefined;

  constructor(private robotService: RobotService) { }

  onMove() {

    this.robotService.moveRobot(this.moves).subscribe({
      next: (value) => { this.response = value },
      error: (error) => { this.response = error }
    })

  }



}
