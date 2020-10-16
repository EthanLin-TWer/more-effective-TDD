import { FirstPins, Frame } from './frame'

export class FinalFrame extends Frame {
  private readonly _thirdPins: FirstPins

  constructor(deliveries) {
    super(deliveries)

    const [, , thirdPins] = deliveries
    this._thirdPins = thirdPins
  }

  get thirdPins(): number {
    return this._thirdPins === 'X' ? 10 : Number(this._thirdPins)
  }

  getScore(nextFrame?: Frame, nextNextFrame?: Frame): number | null {
    if (this.isSpare()) {
      return 10 + Number(this.thirdPins)
    }

    return this.firstPins + this.secondPins + this.thirdPins
  }
}
