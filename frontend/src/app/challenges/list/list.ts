import { CommonModule, isPlatformBrowser } from '@angular/common';
import { ChangeDetectorRef, Component, Inject, OnInit, PLATFORM_ID } from '@angular/core';
import { ChallengeService } from '../challenges.service';
import { Challenges } from '../challenges';

@Component({
  selector: 'app-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list.html'
})
export class ChallengesListComponent implements OnInit {
  challenges: Challenges[] = [];

  constructor(
    private challengeService: ChallengeService
  ) {}

  ngOnInit():void {
      const token = this.getData("token");
      this.challengeService.getChallenges(token).subscribe((res: any) => {
        this.challenges = res as any[];
        console.table(this.challenges);
      });
  }

  public getData(key: string) {
    return localStorage.getItem(key) ?? ''
  }
}
