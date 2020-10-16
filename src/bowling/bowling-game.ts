import { FirstPins, Frame, Score, SecondPins } from './frame'
import { FinalFrame } from './final-frame'

export class BowlingGame {
  private frames: Array<undefined | Frame> = []

  fromRecord(text: string) {
    const frames = text.split(' ')
    frames.forEach((frame, index) => {
      const deliveries = frame.split('') as [FirstPins, SecondPins, FirstPins]
      this.frames[index] =
        index === 9 ? new FinalFrame(deliveries) : new Frame(deliveries)
    })
  }

  public getFrameScore(numberOfFrames: number): Score {
    const currentFrame = this.getFrame(numberOfFrames)
    return currentFrame!.getScore(
      this.getFrame(numberOfFrames + 1),
      this.getFrame(numberOfFrames + 2)
    )
  }

  private getFrame(numberOfFrames: number) {
    return this.frames[numberOfFrames - 1]
  }

  getTotalAsOfFrame(current: number) {
    if (this.getFrame(current)!.isFinished()) {
      return Array(current).reduce(
        (total, _, frame) => total + this.getFrameScore(frame),
        0
      )
    }

    // previous: isolate/spare, current: spare/strike
    const previous = current - 1
    if (this.getFrame(previous)!.isFinished()) {
      return this.getTotalAsOfFrame(current - 1)
    }

    // previous: strike, current: strike
    return this.getTotalAsOfFrame(current - 2)
  }
}
