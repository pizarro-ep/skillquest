import { isPlatformBrowser } from '@angular/common';
import { Component, Inject, OnInit, PLATFORM_ID } from '@angular/core';
import { ChallengeService } from '../challenges.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.html'
})
export class ChallengesListComponent implements OnInit {

  constructor(
    private challengeService: ChallengeService,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {}

  ngOnInit() {
    if (isPlatformBrowser(this.platformId)) {
      const token = localStorage.getItem('token') || '';
      this.challengeService.getChallenges(token).subscribe(res => {
        console.log(res);
      });
    }
  }
}
